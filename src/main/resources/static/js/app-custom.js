
// Hiển thị kiểu tiền VNĐ.
const VND = new Intl.NumberFormat('vi-VN', {
    style: 'currency',
    currency: 'VND'
});

/* ------------------------------------------------------------------------------------------------ */
function displayUserInfor(){
    let str =(document.getElementsByClassName("header-top__userInfor")[0].attributes.item(1).value);
    console.log(str);
    if (str.match("display: none;")) {
        document.getElementsByClassName("header-top__userInfor")[0].style.display = "block";
    } else {
        document.getElementsByClassName("header-top__userInfor")[0].style.display = "none";

    }
}
/* ------------------------------------------------------------------------------------------------ */




















