//item_ajax_managing.js
const itemList=document.getElementById("itemList");
const itemClone=document.getElementById("itemClone");
const pillsInsertTab=document.getElementById("pills-insert-tab");
const pillsListTab=document.getElementById("pills-list-tab");
const pillsModifyTab=document.getElementById("pills-modify-tab");
const itemForm=document.forms["itemForm"];
const pillsInsertTab2 = new bootstrap.Tab(pillsInsertTab);
const pillsListTab2 = new bootstrap.Tab(pillsListTab);
const pillsModifyTab2 = new bootstrap.Tab(pillsModifyTab);

const insertModar=document.getElementById("insertModar");
const insertModar2=new bootstrap.Modal(insertModar);

const listReloadBtn=document.getElementById("listReloadBtn");

listReloadBtn.addEventListener(("click"),(e)=>{
	insertModar2.hide();
	pillsListTab2.show();
	itemListFetch();
})


pillsInsertTab2.show();
//insertModar2.hide();

//pillsListTab2.show();
//pillsModifyTab2.show();

const AJAX_URL="./ajax.do";

itemForm.addEventListener("submit",async(e)=>{
	e.preventDefault(0);
	const inputNodes=(itemForm.querySelectorAll("[name]"));	
	//{tite:"dd",count:10}
	const postData=new Object();
	for( let input of inputNodes){
		postData[input.name]=input.value;
	}
	//console.log(postData);
	let res=await fetch(AJAX_URL,{
		method:"post",
		body:JSON.stringify(postData)
	});
	let json=await res.json();
	insertMsg.innerText=(json.insert)?"등록 성공":"등록실패";
	
	insertModar2.show();
});

itemListFetch();
async function itemListFetch(){
	let res=await fetch(AJAX_URL);
	let json=await res.json();
	itemList.innerHTML="";
	json.forEach((item)=>{
		const itemNode=itemClone.cloneNode(true);
		for(let key in item){
			if(itemNode.querySelector(`.${key}`)){
				itemNode.querySelector(`.${key}`).innerText=item[key];				
			}
			itemNode.id="";
			//console.log(`${key}:${item[key]}`);
	
		}
		itemList.append(itemNode);
	});
};