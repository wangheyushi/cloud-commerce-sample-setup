/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.setup;

import static de.hybris.constants.ECP5106PatchConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.constants.ECP5106PatchConstants;
import de.hybris.service.ECP5106PatchService;


@SystemSetup(extension = ECP5106PatchConstants.EXTENSIONNAME)
public class ECP5106PatchSystemSetup
{
	private final ECP5106PatchService ECP5106PatchService;

	public ECP5106PatchSystemSetup(final ECP5106PatchService ECP5106PatchService)
	{
		this.ECP5106PatchService = ECP5106PatchService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		ECP5106PatchService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ECP5106PatchSystemSetup.class.getResourceAsStream("/ECP5106Patch/sap-hybris-platform.png");
	}
}
