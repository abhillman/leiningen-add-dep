# add-dep

A Leiningen plugin that adds an `add-dep` task, thus alloing for `lein add-dep 'com.google.guava:guava:31.1.3-jre'` for adding dependencies.

## Usage

Clone this repository and run  `lein install` to install this plugin into your local machine's maven repository. Then,  put `[add-dep "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your `project.clj`.

    # Adds [com.google.guava/guava "31.1.3-jre"] to your `project.clj` file
    $ lein add-dep com.google.guava:guava:31.1.3-jre

## Caveat Emptor

This is among the first Clojure projects the author has crafted and the first leiningen plugin. Thus, this code made not be idiomatic; and moreover, `add-dep` may not be idiomatic for `lein`. That said, this was fun to write and PRs are most welcome.

## Potential Roadmap

Depending on the author's usage of this plugin and/or the interests of others in the Clojure community, the following functionality may be added. Please feel free to file an issue to indicate interest.

As a user of the `add-dep` lein plugin, one would be able to...
* allow for removing dependencies
* allow for specifying dependencies with a flag
* allow for warning for the presence of multiple dependencies with different versions

Other considered functionality:
* the ability to automatically fetch the latest version number for a given dependency 
* tool for validating a dependency exists by using `maven`, `clojars`, etc. APIs

## License

Copyright © 2023 Aryeh Hillman 

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
