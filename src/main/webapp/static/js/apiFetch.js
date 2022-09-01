const cartBtn = () => {
    const addSingleProperty = document.querySelectorAll('#addSingleProperty');
    addSingleProperty.forEach(elem => elem.addEventListener('click', async () => {
        console.log("Add cart btn " + elem.id + " " + elem.name)
        // const dataToBePosted = {
        //     id: elem.name
        // };
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

const init = () => {
    cartBtn()
}

init()