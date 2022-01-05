## Proxy Pattern

> With a **Proxy** object, we get more control over the interactions with certain objects. A proxy object can determine the behavior whenever we;re interacting with the object.

A proxy means a stand-in for soeone else. Instead of speacking to that person directly, you'll speak to the proxy person who will represent the person you were trying to reach.

Let's create a person object

```javascript
const person = {
  name: "John Doe",
  age: 42,
  nationality: "American",
};
```

Instead of interacting with this object directly, we want to interact with a proxy object. In JS, _we can easily create a new proxy with by creating a new instance of Proxy_.

```javascript
const person = {
  name: "John Doe",
  age: 42,
  nationality: "American",
};

const personProxy = new Proxy(person, {});
```

The first argument of Proxy is an object that represents the handler. IN the handler object, we can define specific behavior based on the type of interaction. Although there are many methods that you can add to the Proxy handler, the two most common ones are **get** and **set**:

- get: Gets invoked when trying to access a property
- set: Gets invoked when trying to modify a property

```javascript
const personProxy = new Proxy(person, {
  get: (obj, prop) => {
    console.log(`The value of ${prop} is ${obj[prop]}`);
  },
  set: (obj, prop, value) => {
    console.log(`Change ${prop} from ${obj[prop]} to ${value}`);
    obj[prop] = value;
    return true;
  },
});
```

A proxy can be useful to add **validation**. A user shouldn't be able to change person's age to a string value, or give him an empty name. Or if the user is trying to access a property on the object that doesn't exist, we should let the user know.
