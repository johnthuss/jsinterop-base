/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package jsinterop.base;

import static jsinterop.base.FunctionAssert.assertFunctionMatches;

import com.google.gwt.junit.client.GWTTestCase;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

/** Tests for verifying {@link Any} optimize out by compiler. */
public class AnyOptimizationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsMethod
  private static void asPrimitive(String objectField) {
    double d = Any.of(objectField).asDouble();
    float f = Any.of(objectField).asFloat();
    long l = Any.of(objectField).asLong();
    int x = Any.of(objectField).asInt();
    short s = Any.of(objectField).asShort();
    char c = Any.of(objectField).asChar();
    byte b = Any.of(objectField).asByte();
    boolean bool = Any.of(objectField).asBoolean();
  }

  @JsProperty
  private static native Object getAsPrimitive();

  public void testAsPrimitive() {
    assertFunctionMatches(getAsPrimitive(), "");
  }

  @JsMethod
  private static void uncheckedCast(Object objectField) {
    String s = Any.of(objectField).uncheckedCast();
  }

  @JsProperty
  private static native Object getUncheckedCast();

  public void testUncheckedCast() {
    assertFunctionMatches(getUncheckedCast(), "");
  }
}