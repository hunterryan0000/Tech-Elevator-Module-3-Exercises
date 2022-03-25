let clickCounter = 0;

console.log('Hello purple');

document.addEventListener('DOMContentLoaded', onDomReady);

// This is called when the DOM is loaded
// so we can add event listeners & manipulate the DOM
function onDomReady() {
    let addButton = document.getElementById('btn-add');
    addButton.addEventListener('click', makeColorBlockDiv);
}

function makeColorBlockDiv() {
    // Clicked the add button, so increment the counter
    clickCounter++;

    // Create the color block div and append to the main element
    let target = document.querySelector('main');
    let colorBlockDiv = document.createElement('div');
    colorBlockDiv.setAttribute('class', 'block'); // block base styling
    colorBlockDiv.classList.add('red'); // make it red to start
    target.append(colorBlockDiv);

    // Create the counter text & add to the div
    let textPara = document.createElement('p');
    textPara.innerText = clickCounter;
    colorBlockDiv.append(textPara);

    // Create our delete button & add to the div
    let deleteBtn = document.createElement('button');
    deleteBtn.innerText = "Delete";
    colorBlockDiv.append(deleteBtn);
    // Add a click handler to remove the div when the delete is clicked
    deleteBtn.addEventListener('click', (event) => {
        let button = event.target;
        let div = button.parentNode;
        div.remove();
    })

    // Add another click handler to the div to change the color 
     colorBlockDiv.addEventListener('click', toggleColor); // passes in event automatically
    
    // What if our event handler needs another value too?
    // Note some other param is not *really* needed, just added as an example
    // colorBlockDiv.addEventListener('click', (event) => {
    //     toggleColor(event, "Hello Purple")
    // });
}

function toggleColor(event, someOtherParam) {
    console.log('The other param is', someOtherParam);
    let div = event.target;
    if (div.classList.contains('red')) {
        div.classList.remove('red');
        div.classList.add('green');
    } else if (div.classList.contains('green')) {
        div.classList.remove('green');
        div.classList.add('red');
    } 
}