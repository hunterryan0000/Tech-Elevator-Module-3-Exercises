let clickCounter = 0;

console.log("Hello Purple");

document.addEventListener('DOMContentLoaded', onDomReady);

//Called when DOM is loaded so we can add event listeners & manipulate the DOM
function onDomReady() {
    let addButton = document.getElementById('btn-add');
    addButton.addEventListener('click', makeColorBlockDiv);
}

function makeColorBlockDiv() {
    //Increment the counter
    clickCounter++;

    //create the color block div and append to main
    let target = document.querySelector('main');
    let colorBlockDiv = document.createElement('div');
colorBlockDiv.setAttribute('class', 'block'); // block base styling
colorBlockDiv.classList.add('red'); // make it red to start 
    target.append(colorBlockDiv);

    //Create the counter text and append to div
    let textPara = document.createElement('p');
    textPara.innerText = clickCounter;
    colorBlockDiv.append(textPara);

    // create delete button and add to the div
    let deleteBtn = document.createElement('button');
    deleteBtn.innerText = 'Delete';
    colorBlockDiv.append(deleteBtn);
    //Add click handler to remove the div when the delete is clicked
    deleteBtn.addEventListener('click', (event) => {
        let button = event.target;
        let div = button.parentNode;
        div.remove();
    })

    colorBlockDiv.addEventListener('click', toggleColor);
    
    //browser calls function after 'click' event
    function toggleColor(event) {
        let div = event.target;

        if (div.classList.contains('red')) {
        div.classList.remove('red');
        div.classList.add('green');
        } else {
            div.classList.remove('green');
            div.classList.add('red');
        }
    }
}