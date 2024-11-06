# Interactive "self-contained" html with scala.js

Just put the output of scala.js into html file itself.

```sh
scala-cli package --js -f --js-mode full start.scala && \
  scala-cli run gen_index.scala && \
  open index.html
```
