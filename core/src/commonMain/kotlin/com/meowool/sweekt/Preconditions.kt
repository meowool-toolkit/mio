@file:Suppress("NOTHING_TO_INLINE")

package com.meowool.sweekt

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


/**
 * If this boolean value is `true`, returns the result of [block] execution, otherwise
 * returns `null`.
 */
inline fun <R> Boolean?.ifTrue(block: () -> R): R? {
  contract { callsInPlace(block, InvocationKind.AT_MOST_ONCE) }
  return if (this == true) block() else null
}

/**
 * If this boolean value is `true`, returns this boolean object, otherwise returns `null`.
 */
inline fun <R> Boolean?.ifTrue(): Boolean? = this.ifTrue { this }
