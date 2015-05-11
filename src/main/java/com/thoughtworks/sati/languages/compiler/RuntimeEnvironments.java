package com.thoughtworks.sati.languages.compiler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RuntimeEnvironments {

  public static final String ENVIRONMENT_NOT_SET = "Environment not set for command";
  static Map<String, RuntimeEnvironment> environments = Collections.synchronizedMap(new HashMap<>());

  public static RuntimeEnvironment store(String name, RuntimeEnvironment runtimeEnvironment) {
    if (!environments.containsKey(name)) {
      environments.put(name, runtimeEnvironment);
    }
    return environments.get(name);
  }

  public static Optional<RuntimeEnvironment> retrieve(String name) {
    return Optional.ofNullable(environments.get(name));
  }

  public static <T> Optional<T> retrieve(Class<T> clazz, String name) {
    Optional<RuntimeEnvironment> _environment = retrieve(Thread.currentThread().getName());
    RuntimeEnvironment environment = _environment.get();
    if (environment.getClass().isAssignableFrom(clazz)) {
      return Optional.of(clazz.cast(environment));
    }
    return Optional.empty();
  }
}
