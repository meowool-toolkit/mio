@file:Suppress("NOTHING_TO_INLINE")

package com.meowool.mio.internal

import java.nio.ByteBuffer
import kotlin.experimental.ExperimentalTypeInference

internal const val IntPlaceholder = -1
internal const val LongPlaceholder = -1L

@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
internal inline fun Int.ifBoolPlaceholder(another: () -> Boolean): Boolean =
  if (this == IntPlaceholder) another() else this == 1

@JvmName("ifBoolPlaceholderInt")
internal inline fun Int.ifBoolPlaceholder(another: () -> Int): Boolean =
  (if (this == IntPlaceholder) another() else this) == 1

internal inline fun Int.ifPlaceholder(another: () -> Int): Int =
  if (this == IntPlaceholder) another() else this

internal inline fun Long.ifPlaceholder(another: () -> Long): Long =
  if (this == LongPlaceholder) another() else this

internal inline fun Boolean.toInt(): Int = if (this) 1 else 0