//item_ajax_managing.js
const itemList=document.getElementById("itemList");
const itemClone=document.getElementById("itemClone");
const pillsInsertTab=document.getElementById("pills-insert-tab");
const pillsListTab=document.getElementById("pills-list-tab");
const pillsModifyTab=document.getElementById("pills-modify-tab");

const itemForm=document.forms["itemForm"];
const itemModifyForm=document.forms["itemModifyForm"];


const pillsInsertTab2 = new bootstrap.Tab(pillsInsertTab);
const pillsListTab2 = new bootstrap.Tab(pillsListTab);
const pillsModifyTab2 = new bootstrap.Tab(pillsModifyTab);

const insertModar=document.getElementById("insertModar");
const insertModar2=new bootstrap.Modal(insertModar);

const updateModar=document.getElementById("updateModar");
const updateModar2=new bootstrap.Modal(updateModar);

const listReloadBtn=document.getElementById("listReloadBtn");
const listReloadBtn2=document.getElementById("listReloadBtn2");
listReloadBtn2.addEventListener("click",(e)=>{
	updateModar2.hide();
	pillsListTab2.show();
	itemListFetch();
});
listReloadBtn.addEventListener("click",(e)=>{
	insertModar2.hide();
	pillsListTab2.show();
	itemListFetch();
});


//pillsInsertTab2.show();
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
//업데이트
itemModifyForm.addEventListener("submit",async (e)=>{
	e.preventDefault(0);
	//rest api put 방식으로 통신 (Get,Post,Put,Delete}})=>모든 http 통신에서 가능하다. 
	
	const inputNodes=(e.target.querySelectorAll("[name]"));	
	//{tite:"dd",count:10}
	const putData=new Object();
	for( let input of inputNodes){
		putData[input.name]=input.value;
		if(input.name=="sale_time"||input.name=="sale_end_time"){
			let v=input.value;
			if(v){//"" null NaN undefined
				let v_list=v.split("T");
				let date=v_list[0];
				let time_list=v_list[1].split(":");
				v=date+" "+time_list[0]+":"+time_list[1]+":00";	
				putData[input.name]=v;
				console.log(v);				
			}
		}
	}

	let res=await fetch(AJAX_URL,{
		method:"put",
		body: JSON.stringify(putData)
	});
	let json=await res.json()
	console.log(json);
	updateModar2.show();
	if(json.update){
		updateMsg.innerText="수정성공"
	}else{
		updateMsg.innerText="수정실패"

	}
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
				if(key=="title"){
					itemNode.querySelector(`.${key}`).dataset.num=item["item_num"];
				}		
			}
			itemNode.id="";
			//console.log(`${key}:${item[key]}`);
	
		}
		itemList.append(itemNode);
	});
};

async function modifyLoad(e){
	let item_num=(e.target.dataset.num);
	pillsModifyTab2.show();
	let res=await fetch(AJAX_URL+"?item_num="+item_num);
	let json=await res.json();
	console.log(json);
	const input_list=(itemModifyForm.querySelectorAll("[name]"));
	input_list.forEach((input)=>{
		//console.log(input.value,input.name)
		if(input.name=="post_time" || input.name=="sale_time" || input.name=="sale_end_time"){
			let value=json[input.name];
			value=value.replace(" ","T");
			input.value=value;
		}else{
			input.value=json[input.name];			
		}
	});
}






