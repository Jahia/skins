/*
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2020 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
 */
package org.jahia.modules.filter;

import org.jahia.services.render.RenderContext;
import org.jahia.services.render.Resource;
import org.apache.commons.lang.StringUtils;
import org.jahia.services.render.filter.AbstractFilter;
import org.jahia.services.render.filter.RenderChain;
import org.jahia.services.render.filter.RenderFilter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * SkinFilter
 *
 * Filter that add skins to the current resource.
 *
 * If a skin parameter is found, the filter just adds it to the wrappers list.
 *
 */
@Component(service = RenderFilter.class)
public class SkinFilter extends AbstractFilter {

    @Activate
    public void activate() {
        setDescription("Filter that add skins to the current resource.");
        setPriority(45);
        setApplyOnNodeTypes("jmix:droppableContent");
        setSkipOnConfigurations("include,wrapper");
        setSkipOnModes("studio");
    }
    public String prepare(RenderContext renderContext, Resource resource, RenderChain chain) throws Exception {
        String skin = resource.getNode().hasProperty("j:skin")?resource.getNode().getPropertyAsString("j:skin"):"";
        if (!StringUtils.isEmpty(skin) && !skin.equals("none")) {
            resource.pushWrapper(skin);
        }
        return null;
    }
}
