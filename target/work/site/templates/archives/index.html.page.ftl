<#include "/_page.ftl"><@pageLayout><div id="blog-archives">
<#assign year = "0000">
<#list site.posts as post>
<#assign this_year = post.date?string("yyyy")>
<#if year != this_year>
<#assign year = this_year>
  <h2>${ year }</h2>
</#if>
<article>
	<#include "/post/archive_post.ftl">
</article>
</#list>
</div>
</@pageLayout>