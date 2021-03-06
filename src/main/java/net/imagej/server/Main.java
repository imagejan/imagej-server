/*
 * #%L
 * ImageJ server for RESTful access to ImageJ.
 * %%
 * Copyright (C) 2013 - 2016 Board of Regents of the University of
 * Wisconsin-Madison.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package net.imagej.server;

import net.imagej.ImageJ;

/**
 * Main class for imagej-server.
 * 
 * @author Leon Yang
 */
public class Main {

	public static void main(String[] args) throws Exception {
		final ImageJ ij = new ImageJ();
		ij.ui().setHeadless(true);
		final String[] arguments = args == null || args.length == 0 ? new String[] {
			"server", "imagej-server.yml" } : args;
		final ImageJServerApplication app = new ImageJServerApplication(ij
			.context());
		app.run(arguments);
		app.join();
		ij.context().dispose();
	}

}
