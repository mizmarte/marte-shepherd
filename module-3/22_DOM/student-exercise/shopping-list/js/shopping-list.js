// add pageTitle
  const pageTitle = 'My Shopping List'
// add groceries
  let groceries = [
    'turkey bacon','eggs','shrimp','lump crabmeat','paper plates','bleach','honey granola cookies','bananas','spinach','fresh mango'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() 
{
   const title = document.getElementById('title');
   title.innerHTML = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() 
{
  const parentContainer = document.getElementById('groceries');
  groceries.forEach((item) => {
    const li = document.createElement('li')
    li.innerText = item;
    parentContainer.appendChild(li);
  })
  
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() 
{
  const parentContainer = document.getElementById('groceries');
  const item = parentContainer.children;
  for (let i = 0; i < item.length; i++)
  {
    item[i].setAttribute('class','completed');
  };

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
