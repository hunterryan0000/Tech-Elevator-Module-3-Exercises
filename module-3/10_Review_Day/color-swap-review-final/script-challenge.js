let clickCounter = 0; 

document.addEventListener('DOMContentLoaded', onDomReady);

function onDomReady() {
    // Add event listener/handler for the Add Button
    document.getElementById('btn-add').addEventListener('click', addColorBlock)
    
    // Add single event listener to handle color toggle & delete
    document.querySelector('main').addEventListener('click', (event) => {
        // Check for a delete button click
        if ( event.target.classList.contains('btn-delete') ) {
            event.target.parentNode.remove();
        } // Check for a block click
        else if ( event.target.classList.contains('block') ) {
            toggleColor(event);
        }
    });
}

function addColorBlock() {

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
    deleteBtn.setAttribute('class', 'btn-delete'); // add class to target button 
    deleteBtn.innerText = "Delete";
    colorBlockDiv.append(deleteBtn);
    // Add a click handler to remove the div when the delete is clicked
    // deleteBtn.addEventListener('click', (event) => {
    //     let button = event.target;
    //     let div = button.parentNode;
    //     div.remove();
    // })

    // Add another click handler to the div to change the color 
    // colorBlockDiv.addEventListener('click', toggleColor); // passes in event automatically
    
}

function toggleColor(event) {
    let block = event.target;
    if (block.classList.contains('red')){
        block.classList.remove('red');
        block.classList.add('green');
    } else if (block.classList.contains('green')){
        block.classList.remove('green');
        block.classList.add('red');
    }
}