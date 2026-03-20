
async function assignRandomWordToInput(input) {
  
  if (input.type != 'text') { return }

  input.value = "Generating..."

  let response = await fetch('https://random-word-api.herokuapp.com/word');
  if (!response.ok) { 
    input.value = "Failed to generate"
    return 
  }
  let result = await response.json();
  let randomWord = result[0];
  let name = randomWord;
  input.value = name.substring(0, input.maxLength)
}


document.querySelectorAll("input").forEach(assignRandomWordToInput);