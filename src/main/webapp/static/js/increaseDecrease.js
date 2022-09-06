const cartNumberValue = document.querySelectorAll('#number');
cartNumberValue.forEach(elem => console.log(elem.value + " " + elem.getAttribute("data-id")))

let value = 0;

function increaseValue(elemId) {
    // console.log("De ce nu mergi Test 1045")
    // console.log(cartNumberValue)
    // cartNumberValue.forEach(elem => () => {
    //     console.log(" Elem Value" + " increaseValue")
    //     if (elem.getAttribute("data-id").toString().toLowerCase() === elemId.toString().toLowerCase()) {
    //         elem.innerText = elem.value++;
    //         console.log("elem.value" + elem.value)
    //     }
    // })
    for (const increaseBtn of cartNumberValue) {
        if (increaseBtn.getAttribute("data-id").toString().toLowerCase() === elemId.toString().toLowerCase()) {
            value++
            increaseBtn.value = value
        }
    }
    productNumber(value, "increase")
}

function decreaseValue(elemId) {
    // console.log("De ce nu mergi doi Test 1045")
    // cartNumberValue.forEach(elem => () => {
    // cartNumberValue.forEach(elem => () => {
    //     console.log(" Elem Value" + " decreaseValue")
    //     if (elem.getAttribute("data-id").toString().toLowerCase() === elemId.toString().toLowerCase()){
    //         elem.innerText = elem.value--
    //         console.log("elem.value" + elem.value)
    //     }
    // })
    for (const elem of cartNumberValue) {
        if (elem.getAttribute("data-id").toString().toLowerCase() === elemId.toString().toLowerCase()) {
            value--
            elem.value = value
        }
    }
    productNumber(value, "decrease")
}

const productNumber = (number, type) => {
    let numberOfProducts = document.querySelectorAll('.increaseDecrease');
    numberOfProducts.forEach(elem => elem.addEventListener('click', async () => {
        let response = await fetch(`/api/` + type.toLowerCase(), {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            numberOfProperties: JSON.stringify(number.toString()),
            propertyId: JSON.stringify(number.toString())
        });
        const data = await response.json();
    }))
}

// https://www.google.com/maps/dir/Strada+Dealul+%C8%9Augulea,+Bucure%C8%99ti/Pasul+Bratocea/@44.5010319,26.0436256,13.54z/am=t/data=!4m13!4m12!1m5!1m1!1s0x40b201bafc7a1d43:0x130095f8de735835!2m2!1d26.0311774!2d44.4391387!1m5!1m1!1s0x40b3710bd0fd2ccb:0x40be0586ec823e5a!2m2!1d25.8968139!2d45.48037
console.log("The end")
