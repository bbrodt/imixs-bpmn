package org.imixs.bpmn.model;

import org.eclipse.bpmn2.IntermediateCatchEvent;
import org.eclipse.bpmn2.modeler.core.features.CustomShapeFeatureContainer;
import org.eclipse.bpmn2.modeler.core.model.ModelDecorator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EAttributeImpl;

public class ActivityEventDefinitionContainer  extends CustomShapeFeatureContainer {
	
	IntermediateCatchEvent x;
	// these values must match what's in the plugin.xml
		public final static String ACTIVITYNTITY_TASK_ID = "org.imixs.workflow.bpmn.ActivityEntityEvent";

		/**
		 * This method inspects the object to determine what its custom task ID
		 * should be. In this case, we check the namespace of the "type" attribute.
		 * If the namespace matches the imixs targetNamespace, return the
		 * PROCESSENTITY_TASK_ID string.
		 */
		@Override
		public String getId(EObject object) {
			EStructuralFeature feature = ModelDecorator.getAnyAttribute(object,
					"type");
			if (feature != null && feature instanceof EAttribute) {
				if (ImixsRuntimeExtension.targetNamespace
						.equals(((EAttributeImpl) feature).getExtendedMetaData()
								.getNamespace())) {
					return ACTIVITYNTITY_TASK_ID;
				}
			}

			return null;
		}

		@Override
		public boolean canApplyTo(Object o) {
			boolean b1 =  o instanceof IntermediateCatchEvent;
			boolean b2 = o.getClass().isAssignableFrom(IntermediateCatchEvent.class);
			return b1 || b2;
		}
	
}