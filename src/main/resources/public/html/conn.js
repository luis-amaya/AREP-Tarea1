fetch("" + domain() + "")
    .then(response => response.json())
    .then(data => console.log(data));