const cartBtn = () => {
    const addSingleProperty = document.querySelectorAll('#addSingleProperty');
    addSingleProperty.forEach(elem => elem.addEventListener('click', async () => {
        console.log("Add cart btn " + elem.id + " " + elem.name)
        const response = await fetch(`/api/getCart`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(elem.name)
        });
        await console.log(elem.name + " Data")
        const data = await response.json();
        await console.log(data);
    }))
}

const deleteFromMem = async (id) => {
    await fetch(`/api/deleteProduct`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(id)
    });
}

const deleteItem = () => {
    console.log("asdadsasdan kml")
    const formId = document.querySelectorAll("#formId");
    const deleteBtn = document.querySelectorAll(".buttonHandicapat");
    const singleProperty = document.querySelectorAll(".divProst");
    console.log(singleProperty)
    deleteBtn.forEach(elem => elem.addEventListener('click', () => {
        console.log("a intrat")
        for (const argument of singleProperty) {
            console.log("a intrat iar")
            for (const form of formId) {
                if (elem.name === argument.getAttribute("data-id")) {
                    if (form.name === elem.name) {
                        argument.innerHTML = "";
                        form.innerHTML = "";
                        deleteFromMem(form.name)
                    }
                }
            }
        }
    }))
}

const init = () => {
    cartBtn()
    deleteItem()
}

init()