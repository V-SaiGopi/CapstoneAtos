class CartItem{
  constructor(name,img,price){
    this.name=name
    this.img=img
    this.price=price
    this.quantity=1
  }
}

class LocalCart{
  static key="cartItemss"
  static getLocalCartItems(){
    let cartMap=new Map()
    const cart=localStorage.getItem(LocalCart.key)
    if(cart===null || cart.lenght===0) return cartMap
      return new Map(Object.entries(JSON.parse(cart)))
  }
  static addItemToLocalCart(id,item){
    const emptyCartTextEle=document.querySelector('.empty-cart-text');
    emptyCartTextEle.textContent=""
    let cart=LocalCart.getLocalCartItems()
    if(cart.has(id)){
      let mapItem=cart.get(id)
      mapItem.quantity+=1
      cart.set(id,mapItem)
    }else{
      cart.set(id,item)
    }
    localStorage.setItem(LocalCart.key,JSON.stringify(Object.fromEntries(cart)))
    updateCartUI()
  }
  static removeItemFromCart(id){
    let cart=LocalCart.getLocalCartItems()
    if(cart.has(id)){
      let mapItem=cart.get(id)
      if(mapItem.quantity>1){
        mapItem.quantity-=1
        cart.set(id,mapItem)
      }
      else{
        cart.delete(id)
      }
    }
    if(cart.lenght===0){
      localStorage.clear()
    }else{
      localStorage.setItem(LocalCart.key,JSON.stringify(Object.fromEntries(cart)))
      updateCartUI()
    }
  }
}




let wholeCartWindow = document.querySelector(".whole-cart-window");
const cartIcon = document.getElementById("cartIcon");
const addToCartBtn=document.querySelectorAll('.add-to-cart-btn')
addToCartBtn.forEach((btn)=>{
  btn.addEventListener('click',addItemFunction)
})

function addItemFunction(e){
  const id=e.target.parentElement.getAttribute("data-id")
  const img=e.target.previousElementSibling.previousElementSibling.previousElementSibling.src
  const name=e.target.previousElementSibling.previousElementSibling.textContent
  const price=e.target.previousElementSibling.textContent

  const item=new CartItem(name,img,price)
  LocalCart.addItemToLocalCart(id,item)
  // console.log(price)


}

cartIcon.addEventListener('click',function(){

    wholeCartWindow.classList.toggle('hide')

})


function updateCartUI(){
  const cartWrapper=document.querySelector('.cart-wrapper')
  cartWrapper.innerHTML=""
  const items=LocalCart.getLocalCartItems('cartItemss')

  if(items===null){

  }
  localStorage.setItem('totalAmount',0)
  // console.log(typeof(localStorage.getItem('totalAmount')))
  let count=0
  let total=0
  for(const [key,value] of items.entries()){
    const cartItem=document.createElement('div')
    cartItem.classList.add('cart-item')
    let money=parseInt((value.price).replaceAll(",",""))*parseInt(value.quantity)
    // let amount=parseInt(value.price)*parseInt(value.quantity)
    count+=1

    total+=money
    // console.log(total)

    cartItem.innerHTML=`
      <img src=${value.img} />
      <div class="details">
          <h3>${value.name}</h3>

              <span class="quantity">Quantity: ${value.quantity}</span>
              <span class="price">Price: ${value.price}/-</span>

      </div>
      <div class="cancel"><i class="fa-solid fa-rectangle-xmark"></i></div>
    `
    cartItem.lastElementChild.addEventListener('click',()=>{
      LocalCart.removeItemFromCart(key)
    })
    cartWrapper.append(cartItem)
  }
  if(count>0){
    cartIcon.classList.add('non-empty')
    let root=document.querySelector(':root')
    root.style.setProperty('--after-content',`"${count}"`)
    const subtotal=document.querySelector('.subtotal')
    subtotal.innerHTML=`Total: ${total}/-`
    localStorage.setItem('totalAmount',JSON.stringify(total))
    // console.log(localStorage.getItem('totalAmount'))
  }else{
    let root=document.querySelector(':root')
    let count=0
    root.style.setProperty('--after-content',`"${count}"`)
    const subtotal=document.querySelector('.subtotal')
    subtotal.innerHTML=`Total: 0/-`
    cartIcon.classList.remove('non-empty')
  }
}

let submitBtn=document.querySelector('.submit-btn');
submitBtn.addEventListener("click",function(){

  let userCouponEle=document.querySelector('.apply-coupen');

  let userCoupon=userCouponEle.value;
  const coupons=['WIN2022','NEW2023','BOH232']
  if(coupons.includes(userCoupon)){
    let invalidText=document.querySelector('.invalid-coupen-text')
    let successMsgEle=document.querySelector('.coupon-success-msg');
    successMsgEle.textContent="Coupon applied Successfully!"
    successMsgEle.classList.add('coupon-success')
    invalidText.textContent=""
    const subtotal=document.querySelector('.subtotal')
    const totalAmount=parseInt((subtotal.textContent.slice(7,-2)))
    if(userCoupon==="WIN2022"){
        let finalPrice=totalAmount-((totalAmount*20)/100)
        subtotal.textContent=`Total: ${finalPrice}/-`
        localStorage.setItem('totalAmount',JSON.stringify(finalPrice))
    }
    else if(userCoupon==="NEW2023"){
      let finalPrice=totalAmount-((totalAmount*30)/100)
      subtotal.textContent=`Total: ${finalPrice}/-`
      localStorage.setItem('totalAmount',JSON.stringify(finalPrice))
    }else{
      let finalPrice=totalAmount-((totalAmount*25)/100)
      subtotal.textContent=`Total: ${finalPrice}/-`
      localStorage.setItem('totalAmount',JSON.stringify(finalPrice))
    }
  }else{
    let successMsgEle=document.querySelector('.coupon-success-msg');
    let invalidText=document.querySelector('.invalid-coupen-text')
    invalidText.textContent="Invalid Coupon"
    successMsgEle.textContent=""
    invalidText.classList.add('invalid');
  }

})

let buyNowBtn=document.querySelector('.buy-now-btn');
buyNowBtn.addEventListener('click',function(){
  // const cart=localStorage.getItem(LocalCart.key)
  const items=localStorage.getItem('cartItemss')
  const emptyCartTextEle=document.querySelector('.empty-cart-text');

  if(items=="{}" || items==undefined){
    emptyCartTextEle.textContent="Empty Cart"
    emptyCartTextEle.classList.add('empty-cart')
  }else{
    window.location.href="paymentpage"
  }

})

// coupons=['WIN2022','NEW2023','BOH232']
// let couponEle=document.querySelector('.apply-coupen')
// couponEle.addEventListener('change',function(event){
//   const val=event.target.value;
//   console.log(val)
// })



// window.onload=function(){
//   // const items=localStorage.setItem('cartItems',{})


// }
// localStorage.clear()
// updateCartUI()




document.addEventListener('DOMContentLoaded',()=>{updateCartUI()})






let logUser=document.querySelector('.logged-user-name');
logUser.textContent="Hi "+localStorage.getItem('loggedUser')






















// wholeCartWindow.inWindow=0
//
//
// cartIcon.addEventListener('mouseover',function(){
//
//     wholeCartWindow.classList.remove('hide')
//
// })
//
// cartIcon.addEventListener("mouseleave",function(){
//   setTimeout(()=>{
//     if(wholeCartWindow.inWindow===0){
//       wholeCartWindow.classList.add('hide')
//     }
//   },500)
// })
// wholeCartWindow.addEventListener("mouseover", function() {
//   wholeCartWindow.inWindow=1
// });
// wholeCartWindow.addEventListener('mouseleave',function(){
//   wholeCartWindow.inWindow=0
//   wholeCartWindow.add('hide')
// })
