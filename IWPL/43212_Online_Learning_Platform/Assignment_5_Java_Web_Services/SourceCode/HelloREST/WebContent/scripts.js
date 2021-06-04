const app = document.getElementById('root');



const container = document.createElement('div');
container.setAttribute('class', 'container');

app.appendChild(container);

var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8080/HelloREST/rest/authenticate/company', true);
request.onload = function () {

  // Begin accessing JSON data here
  var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
    data.forEach(company => {
      console.log(company.ctc,company.name,company.type,company.location)
      
      const card = document.createElement('div')
      card.setAttribute('class', 'card')

      const h1 = document.createElement('h1')
      h1.textContent = company.name

      const p = document.createElement('p')
      p.textContent = `CTC : ${company.ctc} `
    	  
    	  const q = document.createElement('p')
          q.textContent = `TYPE : ${company.type} `
        	  
        	  const r = document.createElement('p')
              r.textContent = `Location : ${company.location}`

      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(p)
      card.appendChild(q)
      card.appendChild(r)
      
    });
  } else {
    const errorMessage = document.createElement('marquee');
    errorMessage.textContent = `Gah, it's not working!`;
    app.appendChild(errorMessage);
  }
}

request.send();