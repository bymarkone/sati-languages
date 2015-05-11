package com.thoughtworks.sati.languages.multi;

import com.google.inject.Inject;
import com.thoughtworks.sati.languages.compiler.Compiler;
import com.thoughtworks.sati.languages.compiler.Runtime;

public class MultiLanguageCompiler implements Compiler {
  private AllCompilers allCompilers;

  @Inject
  public MultiLanguageCompiler(AllCompilers allCompilers) {
    this.allCompilers = allCompilers;
  }

  @Override
  public String name() {
    return "MultiCompiler";
  }

  @Override
  public void compileAndRun(Runtime runtime, String content) {
    allCompilers.compilerToUse().ifPresent(c -> c.compileAndRun(runtime, content));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MultiLanguageCompiler)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return this.getClass().getName().hashCode();
  }
}
