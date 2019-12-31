# Copyright (C) 2019 SenzaCarta
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by SenzaCarta"
DESCRIPTION = "Linux Kernel for SenzaCarta Board. Contact \
				MAINTAINER for more details."

require recipes-kernel/linux/linux-imx.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
DEPENDS += "lzop-native bc-native"

SRCBRANCH = "warrior"
LOCALVERSION = "-1.1.0"
KERNEL_SRC ?= "git://github.com/en-vikrant/linux-senzacarta.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "da5cffa240b920fcecacde3f6ccabbdea64df8ad"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "1"

DEFCONFIG     = "defconfig"
DEFCONFIG_mx6 = "imx_v7_defconfig"
DEFCONFIG_mx7 = "imx_v7_defconfig"

do_preconfigure_prepend() {
    # meta-freescale/classes/fsl-kernel-localversion.bbclass requires
    # defconfig in ${WORKDIR}
    install -d ${B}
    cp ${S}/arch/${ARCH}/configs/${DEFCONFIG_mx7} ${WORKDIR}/defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx7|imx7dsenzacarta)"
