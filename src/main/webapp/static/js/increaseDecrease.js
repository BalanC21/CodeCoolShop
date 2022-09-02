let anaContext = document.querySelectorAll('.anaContext');

let value = 0;
function increaseValue() {
    for (const anaContextElement of anaContext) {
        let addItem = document.querySelectorAll('.addItem');
        for (const addItemElement of addItem) {
            console.log(addItemElement.id)
            if (anaContextElement.getAttribute("data-id") === addItemElement.getAttribute("data-id")) {
                console.log("Aaaaaa")
                value = isNaN(value) ? 0 : value;
                value++;
                anaContextElement.value = value;
            }
        }
    }
}

function decreaseValue() {
    value = document.getElementById('number').value, 10;
    for (const argument of arguments) {

    }
    value = isNaN(value) ? 0 : value;
    value < 1 ? value = 1 : '';
    value--;
    document.getElementById('number').value = value;
}

const productNumber = (number, type) => {
    const numberOfProducts = document.querySelectorAll('form > input');
    console.log(numberOfProducts)
    numberOfProducts.forEach(elem => elem.addEventListener('click', async () => {
        console.log("Add cart btn " + " " + elem.name)
        console.log(elem.getAttribute("data-id"))
        increaseValue(elem.getAttribute("data-id"))
        const response = await fetch('/api/' + type, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(number.toString())
        });
        await console.log(elem.name + " Data")
        const data = await response.json();
        await console.log(data);
    }))
}

function loca() {
    productNumber(value, "increase")
    productNumber(value, "decrease")
}

loca()
