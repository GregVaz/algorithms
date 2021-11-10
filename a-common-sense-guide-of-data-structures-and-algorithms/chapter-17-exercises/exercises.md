1. List all the words stored in the following trie:

```
                                    -
                                  /   \
                                t       w
                              /           \
                            -               -
                          /   \             |
                        a       o           e
                      /           \           \
                    -               -           {"*", l, n}
                /   |   \         /   \             /   \
              g     n    p      d       t         l       n
            /       |     \     |       |         |       |
          "*"   {"*", k}  "*"   -       -         -       -
                    |           |       |         |       |
                    k           a       a         l       t
                    |           |       |         |       |
                   "*"          y       l        "*"     "*"
                                |       |
                               "*"     "*"

```

2. Draw a trie that stores the following words: "get", "go", "got", "gotten", "hall", "ham", "hammer", "hill", and "zebra".

3. Write a function that traverses each node a trie and prints each key, including all "\*" keys.

4. Write an autocomplete function that attempts to replace a user's typo with a correct word. The function should accept a string that represents text a user typed in. If the user's string is not in the trie, the function should return an alternative word that shared the longest possible prefix with the user's string.

One more example: if the user types in “caxasfdij,” the function could return any of the words “cat,” “catnap,” and “catnip,” since they all share the same prefix of “ca” with the user’s typo.

If the user’s string is found in the trie, the function should just return the word itself. This should be true even if the user’s text is not a complete word, as we’re only trying to correct typos, not suggest endings to the user’s prefix.

> 1.r =

```
[tag, tan, tap, tank, today, total, we, well, went]
```

> 2.r =

Words with `g`

```
                                    -
                                  /
                                g
                              /
                            -
                          /   \
                        e       o
                      /           \
                    -              {*, t}
                    |             /
                    e            t
                    |            |
                    -          {*, t}
                    |            |
                    t            t
                    |            |
                   "*"           -
                                 |
                                 e
                                 |
                                 -
                                 |
                                 n
                                 |
                                "*"

```

Words with `h`

```
                                -
                                |
                                h
                                |
                                -
                            /       \
                          a           i
                        /               \
                      -                   -
                    /   \                   \
                  l       m                   l
                  |         \                 |
                  -           {"*", m}        -
                  |             |             l
                  l             m             |
                  |             |            "*"
                 "*"            -
                                e
                                |
                                -
                                |
                                r
                                |
                               "*"

```

Words with `z`

```
                    -
                    |
                    z
                    |
                    -
                    |
                    e
                    |
                    -
                    |
                    b
                    |
                    -
                    |
                    r
                    |
                    -
                    |
                    a
                    |
                    -
                    |
                    *

```

> 3.r =
