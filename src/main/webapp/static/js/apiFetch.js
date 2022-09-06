const cartBtn = () => {
    const addSingleProperty = document.querySelectorAll('#addSingleProperty');
    addSingleProperty.forEach(elem => elem.addEventListener('click', async () => {
        const response = await fetch(`/api/getCart`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(elem.name)
        });
        const data = await response.json();
    }))
}

const deleteFromMem = async (id) => {
    console.log("deleteFromMem ")
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
    const formId = document.querySelectorAll("#formId");
    const deleteBtn = document.querySelectorAll(".buttonHandicapat");
    const singleProperty = document.querySelectorAll(".divProst");
    deleteBtn.forEach(elem => elem.addEventListener('click', () => {
        for (const argument of singleProperty) {
            if (elem.name === argument.getAttribute("data-id")) {
                argument.innerHTML = ""
                deleteFromMem(elem.name).then(r => console.log(r))
                for (let form of formId) {
                    if (form.name === elem.name) {
                        form.innerHTML = "";
                        deleteFromMem(form.name).then(r => console.log(r))
                    }
                }
            }
        }
    }))
}

function generateProduct(product) {
    return `
        <div class="col-md-4">
        <div class="card-box-a card-shadow">
            <div class="img-box-a">
                <img class="" src='/templates/assets/img/property-${product.id}.jpg' src="https://placehold.it/400x250/000/fff" alt=""/>
            </div>
            <div class="card-overlay">
                <div class="card-overlay-a-content">
                    <div class="card-header-a">
                        <h2 class="card-title-a">
                            <a href="@{/productDetail(article=${product.id})}" <br/> Olive Road Two</a>
                        </h2>
                    </div>
                    <div class="card-body-a">
                        <div class="price-box d-flex">
                                        <span class="price-a">${product.propertyModelCategory.name} | ${product.defaultPrice}</span>

                        </div>
                        <a href="@{/productDetail(article=${product.id})}" class="link-a">Click
                            here to view
                            <span class="bi bi-chevron-right"></span>
                        </a>
                    </div>
                    <div class="card-footer-a">
                        <ul class="card-info d-flex justify-content-around">
                            <li>
                                <h4 class="card-info-title">Area</h4>
                                <span>${product.ares}
                          <sup>2</sup>
                        </span>
                            </li>
                            <li>
                                <h4 class="card-info-title">Beds</h4>
                                <span>${product.numberOfBeds}</span>
                            </li>
                            <li>
                                <h4 class="card-info-title">Baths</h4>
                                <span>${product.numberOfBaths}</span>
                            </li>
                            <li>
                                <h4 class="card-info-title">Garages</h4>
                                <span>${product.numberOfGarages}</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>`;
}

async function getHtmlCode(result) {
    let contentDiv = document.querySelector(`.decenumergi`)
    contentDiv.innerHTML = ``
    for (const item of result) {
        contentDiv.innerHTML += generateProduct(item)
    }
}

const ana = async (rent) => {
    let filterAna = rent.value
    const dataToBePosted = {
        filterBy: filterAna
    }
    let response = await fetch("/api/sort", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(dataToBePosted)
    })
    const result = await response.json();
    await getHtmlCode(result)

}

async function filterElements() {
    const rent = document.getElementById("filter-option")
    await rent.addEventListener('change', () => ana(rent))
}

const init = () => {
    cartBtn()
    deleteItem()
    filterElements().then()
}

init()