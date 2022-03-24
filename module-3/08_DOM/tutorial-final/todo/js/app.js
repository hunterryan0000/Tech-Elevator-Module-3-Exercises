//you should always reach for `getElementById()` 
//if the element has an id:
const todoList = document.getElementById('todos');

/* variables for your page title and array of todos. 
These values will change later, so make 
sure to use `let` instead of `const`: */
let todos = [];
let pageTitle = '';

// create a method that assigns a page title and array of todos:
function init() {
  pageTitle = 'My Morning Routine';
  todos = [{
      id: 1,
      task: 'Wake up',
      completed: false
    },
    {
      id: 2,
      task: 'Brush Teeth',
      completed: false
    },
    {
      id: 3,
      task: 'Shower',
      completed: false
    },
    {
      id: 4,
      task: 'Get Dressed',
      completed: false
    },
    {
      id: 5,
      task: 'Drive to work',
      completed: false
    },
    {
      id: 6,
      task: 'Work',
      completed: false
    },
    {
      id: 7,
      task: 'Drive home from work',
      completed: false
    },
    {
      id: 8,
      task: 'Dinner',
      completed: false
    },
    {
      id: 9,
      task: 'Brush Teeth',
      completed: false
    },
    {
      id: 10,
      task: 'Go to bed',
      completed: false
    }
  ];
}

/* Once you have a reference to that element, you can set 
the inner text of that element to the page title you initialized.
Finally, you can use the `todoList` that you got a 
reference to earlier and append your new `h1` element to it: */
function addPageTitle() {
  const heading = document.createElement('h1');
  heading.innerText = pageTitle;
  todoList.appendChild(heading);
}

/* In this step, you'll create a method called `addTodos`. 
In this method, you'll create a new unordered list `<ul>` element, 
get a reference to it, and append it to your `todoList` container. 
With that reference, you'll add a new list item `<li>` 
for each todo in the array:

for each loop here to iterate over each todo in the array. 
During each iteration, you'll create a new list item element 
and set the inner text to the value from `todo.task`: */

function addTodos() {
  const ul = document.createElement('ul');
  todos.forEach((todo) => {
    const li = document.createElement('li');
    li.innerText = todo.task;
    ul.appendChild(li);
  });
  todoList.appendChild(ul);
}

// setup our page title and tasks
init();
// // add page title to the DOM
addPageTitle();
// // add the task to the DOM
addTodos();