/*
 * Copyright 2017 the original author or authors.
 *
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
 */

package org.gradle.api.internal.artifacts;

import org.gradle.api.Action;
import org.gradle.api.artifacts.transform.ArtifactTransformAction;
import org.gradle.api.artifacts.transform.ArtifactTransformSpec;
import org.gradle.api.artifacts.transform.ParameterizedArtifactTransformSpec;
import org.gradle.api.artifacts.transform.VariantTransform;

public interface VariantTransformRegistry {

    /**
     * Register an artifact transformation.
     *
     * @see VariantTransform
     */
    void registerTransform(Action<? super VariantTransform> registrationAction);

    <T> void registerTransform(Class<T> parameterType, Action<? super ParameterizedArtifactTransformSpec<T>> registrationAction);

    <T extends ArtifactTransformAction> void registerTransformAction(Class<T> actionType, Action<? super ArtifactTransformSpec> registrationAction);

    Iterable<ArtifactTransformRegistration> getTransforms();
}
