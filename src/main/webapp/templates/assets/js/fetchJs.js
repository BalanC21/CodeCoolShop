const URL_API = " http://localhost:8080/";

const handlePostBtn = () => {
    const postBtn = document.querySelectorAll('#anaViewProduct > a');
    postBtn.forEach(elem => elem.addEventListener('click', async () => {
        const dataToBePosted = {
            id: elem.id
        };
        const response = await fetch("/api/getLinkId", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dataToBePosted)
        });
        console.log(JSON.stringify(dataToBePosted) + " handlePostBtn Js")
        const data = await response.json();
        await console.log(data);
    }))
};

function init() {
    handlePostBtn()
}

init()