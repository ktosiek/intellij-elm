package org.elm.ide.search

import com.intellij.psi.PsiElement
import com.intellij.usages.UsageTarget
import com.intellij.usages.impl.rules.UsageType
import com.intellij.usages.impl.rules.UsageTypeProviderEx
import org.elm.lang.core.psi.elements.ElmField
import org.elm.lang.core.psi.elements.ElmFieldType


class ElmUsageTypeProvider : UsageTypeProviderEx {
    override fun getUsageType(element: PsiElement?, targets: Array<out UsageTarget>): UsageType? {
        // targets?
        return if (element == null)
            null
        else
            getUsageType(element)
    }

    override fun getUsageType(element: PsiElement): UsageType? {
        return when (element) {
            is ElmFieldType -> UsageType.CLASS_FIELD_DECLARATION
            is ElmField -> UsageType.WRITE
            else -> null
        }
    }
}
