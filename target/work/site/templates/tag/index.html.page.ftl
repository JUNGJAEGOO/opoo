<#include "/_page.ftl"><@pageLayout>
<#if site.tags?? &&  (site.tags?size > 0)>
<div id="tag-archives">
<ul style="padding-left:40px;">
<#list site.tags?sort_by("postSize")?reverse as tag>
	<#if (tag.postSize > 0)><li class="category"><a href="${root_url}${tag.url}">${tag.name}</a> (${tag.postSize})</li></#if>
</#list>
  </ul>
 </div>
</#if>
</@pageLayout>