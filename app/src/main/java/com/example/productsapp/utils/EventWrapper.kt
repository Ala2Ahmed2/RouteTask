package com.example.productsapp.utils


/*
 *  Copyright 2017 Google Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
class EventWrapper<T>(content: T?) {
    private val mContent: T

    private var hasBeenHandled = false

    init {
        requireNotNull(content) { "null values in Event are not allowed." }
        mContent = content
    }

    val contentIfNotHandled: T?
        get() {
            if (hasBeenHandled) {
                return null
            } else {
                hasBeenHandled = true
                return mContent
            }
        }

    fun hasBeenHandled(): Boolean {
        return hasBeenHandled
    }
}