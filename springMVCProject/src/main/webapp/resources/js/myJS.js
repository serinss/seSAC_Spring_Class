/**
 * Form과 관련된 함수들의 집합
 */

//Form에서 입력 받을 때 null값 체크 함수 
function isNull(obj, msg){
	if(obj.value == ''){
		alert(msg)
		obj.focus()
		return true
	}
	return false
}