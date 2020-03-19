# JsInterop Base   &middot; [![Build Status](https://secure.travis-ci.org/google/jsinterop-base.png?branch=master)](http://travis-ci.org/google/jsinterop-base)

jsInterop-base contains a set of utilities that cannot be expressed with
Jsinterop itself and allows GWT and J2CL projects to write certain JavaScript
expressions with pure Java.

Bazel dependency
----------------
If your project use [Bazel](https://bazel.build), add this repository as an
external dependency in your `WORKSPACE` file:

```
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
_JSINTEROP_BASE_VERSION = "1.0.0"
http_archive(
    name = "com_google_jsinterop_base",
    strip_prefix = "jsinterop-base-%s" % _JSINTEROP_BASE_VERSION,
    url = "https://github.com/google/jsinterop-base/archive/%s.zip" % _JSINTEROP_BASE_VERSION,
)
```

Then add `@com_google_jsinterop_base//:jsinterop-base-j2cl` to
your `j2cl_library` deps.


Maven dependency
------------------
If your project use [Maven](https://maven.apache.org), add maven dependency in
your pom.xml:

    <dependency>
      <groupId>com.google.jsinterop</groupId>
      <artifactId>base</artifactId>
      <version>1.0.0</version>
    </dependency>


Download the jar file
----------------------
You can also download manually [the jar file](https://oss.sonatype.org/content/repositories/releases/com/google/jsinterop/base/1.0.0/base-1.0.0.jar).

GWT
---
If you use jsinterop-base with [GWT](http://www.gwtproject.org/), you need to
inherit the following gwt module in your gwt.xml file:

    <inherits name="jsinterop.base.Base" />

Build GWT compatible maven jar files
------------------------------------
If you want to build the last version on your own, follow the instructions
below:

- Install [Bazel](https://bazel.build/versions/master/docs/install.html).
- clone this repository with git: `git clone https://github.com/google/jsinterop-base.git`
- Inside the repository, run the script `maven/release_jsinterop_base.sh`:

       $ ./maven/release_jsinterop_base.sh --version local --no-deploy

 The script will output the directory containing the generated jar files that
 can be used with maven.

Contributing
------------
Please refer to [the contributing document](CONTRIBUTING.md).

Licensing
---------
Please refer to [the license file](LICENSE).

Disclaimer
----------
This is not an official Google product.

