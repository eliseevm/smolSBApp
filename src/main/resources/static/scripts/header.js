'use strict';

let header = document.querySelector(".header__wrapper");
let headerInner = `
      <div class="container header">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <img class="bi me-2" width="40" height="32" role="img" aria-label="Logo" src="images/logo.png">
          </a>
        <h1>EMERGENCY SERVICE</h1>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 header__nav">
          <li><a id="main-link" href="/index" class="nav-link px-2 link-dark header__link">Главная</a></li>
          <li><a id="terms-link" href="/index/termsOfUse" class="nav-link px-2 link-dark header__link">Правила</a></li>
          <li><a href="#" class="nav-link px-2 link-dark header__link">Customers</a></li>
          <li><a href="#" class="nav-link px-2 link-dark header__link">Products</a></li>
        </ul>
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>
        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2 header__login">ВХОД</button>
          <button type="button" class="btn btn-warning">РЕГИСТРАЦИЯ</button>
        </div>
        </div>
      </div>
`;
header.insertAdjacentHTML('beforeend', headerInner);


if(document.URL.includes('terms')) {
    let link = document.getElementById('terms-link');
    link.classList.remove('link-dark');
    link.classList.add('link-secondary');
}

if(document.URL.includes('index')) {
    let link = document.getElementById('main-link');
    link.classList.remove('link-dark');
    link.classList.add('link-secondary');
}

