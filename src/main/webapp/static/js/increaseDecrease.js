const cartNumberValue = document.querySelectorAll('#number');

async function modifyValue(elemId, modifier = 1) {
    let value;
    for (const elem of cartNumberValue) {
        if (elem.getAttribute("data-id").toString().toLowerCase() === elemId.toString().toLowerCase()) {
            value = elem.value;
            elem.value = parseInt(value) + parseInt(modifier);
            value = elem.value;
            await getCartDataAPI(modifier, parseInt(value), elemId.toString().toLowerCase())
        }
    }
}

async function getCartDataAPI(modifier, value, elemId) {
    if (modifier === 1) {
        await productNumber(value, "increase", elemId)
    } else {
        await productNumber(value, "decrease", elemId)
    }
}

const productNumber = async (number, type, elemId) => {
    const dataToBePosted = {
        numberOfProperties: number,
        propertyId: elemId
    };
    await fetch(`/api/` + type.toLowerCase(), {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(dataToBePosted)
    });
}
