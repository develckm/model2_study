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

pillsInsertTab2.show();
//pillsListTab2.show();
//pillsModifyTab2.show();

const AJAX_URL="./ajax.do";

itemForm.addEventListener("submit",(e)=>{
	e.preventDefault(0);




});


itemListFetch();
async function itemListFetch(){
	let res=await fetch(AJAX_URL);
	let json=await res.json();
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