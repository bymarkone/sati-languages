package com.thoughtworks.sati.languages.compiler;

public interface Compiler {

  String name();
  void compileAndRun(Runtime runtime, String content);

}
