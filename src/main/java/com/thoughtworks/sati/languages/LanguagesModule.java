package com.thoughtworks.sati.languages;

import com.google.inject.AbstractModule;
import com.thoughtworks.sati.languages.multi.AllCompilers;

public class LanguagesModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(AllCompilers.class).asEagerSingleton();

  }
}
