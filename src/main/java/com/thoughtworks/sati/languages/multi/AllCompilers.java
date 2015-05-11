package com.thoughtworks.sati.languages.multi;

import com.thoughtworks.sati.languages.compiler.Compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Optional.empty;

public class AllCompilers {
  private List<Compiler> compilers;
  private Optional<Compiler> inUseCompiler;

  public AllCompilers() {
    compilers = new ArrayList<>();
    inUseCompiler = empty();
  }

  public void addCompiler(Compiler compiler) {
    if (compilers.contains(compiler))
      compilers.remove(compiler);
    compilers.add(compiler);
  }

  public void addCompiler(int index, Compiler compiler) {
    if (compilers.contains(compiler))
      compilers.remove(compiler);
    compilers.add(index, compiler);
  }

  public Stream<Compiler> compilers() {
    return compilers.stream();
  }

  public Optional<Compiler> compilerToUse() {
    return inUseCompiler.isPresent() ? inUseCompiler : compilers().findFirst();
  }

  public boolean defineCompilerInUse(String name) {
    inUseCompiler = compilers().filter(c -> name.equals(c.name())).findFirst();
    return inUseCompiler.isPresent();
  }
}
