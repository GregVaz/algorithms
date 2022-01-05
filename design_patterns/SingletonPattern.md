## Singleton Pattern

### Share a single global instance throughout our application

Singletons are classes which can be instantiated once, and can be accessed globally. This single instance can be shared thoughout our application, which makes Singletons great for managing global state in an application.

#### Disavantages

Restrict the instantiation to just one instance _could potentially save a lot of memory space_. However, **Singletons are actually considered an anti-pattern** and can (..should) be avoided in JavaScript.

In programming languages such as Java or C++, it's not possible to directly crete object the way we can in JS. In those object-oriented programming languages, we need to create a class, which creates an object. However since we can directly create objects in JavaScript, we can simply use a regular object to achieve the exact same result.

```javascript
let count = 0

const counter = {
  increment() {
    return ++count;
  }

  decrement() {
    return --count;
  }
};

Object.freeze(counter);
export { counter };
```

- Depency hiding

When importing another module, it may not be obvious that that module is importing a Singleton. In other files, such as index.js in this case, we may be importing that module and invoke its methods. This way, we accidentally modify the values in the Singleton. This can lead to unexpected behavior, _since multiple instances of the SIngleton can be shared thorughtout the application_, which woudl all get modified as well.

```javascript
import Counter from "./counter";
import SuperCounter from "./counter";
const counter = new SuperCounter();

counter.increment();
counter.increment();
counter.increment();

console.log("Counter in index.js", Counter.getCounter());
```

- Global behavior

A Singelton instance should be able to get referenced thoughout the entire ap. Global variables essentially show the same behavior: since global variables are available on the global scope.

Having a global variable is generally considered as a bad design decision. Global scope pollution can end up in accidentally overwriting the value of a global variable, which can lead a lot of unexpected behavior.

In ES2015, creating global variables is fairly uncommon.

However, the commong usecase for a Singleton is to have some sort of global state throughout your application. Having multiple parts of your codebase rely on the same mutable object can lead to unexpected behavior.
