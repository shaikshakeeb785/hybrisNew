<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:htmlEscape defaultHtmlEscape="true"/>
<script type="text/javascript" src="${commonResourcePath}/js/jquery-3.4.1.min.js"></script>
<button id="share" class="btn btn-default btn-block"><img alt="logo" src="${contextPath}/_ui/addons/chineseproductsharingaddon/responsive/common/images/shareIcon.png" /></button>

<script type="text/javascript">
$("#share").click(function(){
	ACC.colorbox.open("<spring:theme code='type.ChineseProductSharingComponent.title' />", {
	        href: ACC.config.encodedContextPath + "/product-share/qr?url="+encodeURIComponent(window.location.href),
			width:"400px",
	    	height:"450px",
			initialWidth :"320px",
			onComplete: function () {
                ACC.common.refreshScreenReaderBuffer();
            },
            onClosed: function () {
                ACC.common.refreshScreenReaderBuffer();
            }
	   });
});
</script>

