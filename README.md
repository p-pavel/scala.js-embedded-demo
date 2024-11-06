# Interactive "self-contained" html with scala.js

Just put the output of scala.js into html file itself.

You can check the result at <https://p-pavel.github.io/scala.js-embedded-demo/>

to build:

```sh
scala-cli package --js -f --js-mode full start.scala && \
  scala-cli run gen_index.scala && \
  open index.html
```
