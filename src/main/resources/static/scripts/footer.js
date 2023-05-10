'use strict';
let footer = document.querySelector(".footer");
let footerInner = `
<div class="container">
    <span class="text-muted">&copy 2023 "Emergency Service". Все права защищены.</span>
  </div>`;
footer.insertAdjacentHTML('beforeend', footerInner);
