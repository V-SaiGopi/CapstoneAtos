let loginEle=document.querySelector('.login-btn');
document.addEventListener('click',function(){

  let k=document.querySelector('.user-name-field')
  let y=k.value
  localStorage.setItem('loggedUser',y)
})