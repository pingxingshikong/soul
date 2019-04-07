/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.web.logo;

import org.dromara.soul.common.constant.Constants;
import org.dromara.soul.common.utils.LogUtils;
import org.dromara.soul.common.utils.VersionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * the soul logo.
 *
 * @author xiaoyu
 */
@Order(LoggingApplicationListener.DEFAULT_ORDER + 1)
@SuppressWarnings("all")
public class SoulLogo implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final String SOUL_LOGO = "\n"
            + "                 _  \n"
            + "                | | \n"
            + " ___  ___  _   _| | \n"
            + "/ __|/ _ \\| | | | |\n"
            + "\\__ \\ (_) | |_| | |\n"
            + "|___/\\___/ \\__,_|_|\n"
            + "                    \n"
            + "                   \n";

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SoulLogo.class);

    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
        String bannerText = buildBannerText();
        LogUtils.info(LOGGER, () -> bannerText);
    }

    private String buildBannerText() {
        return Constants.LINE_SEPARATOR
                + Constants.LINE_SEPARATOR
                + SOUL_LOGO
                + Constants.LINE_SEPARATOR
                + " :: Soul :: (v" + VersionUtils.getVersion(getClass(), "1.0.2") + ")"
                + Constants.LINE_SEPARATOR;
    }

}
