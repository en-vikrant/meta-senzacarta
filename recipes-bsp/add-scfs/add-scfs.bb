# Copyright (C) 2020 SenzaCarta

SUMMARY = "SenzaCarta Project Directory Structure"
# FIXME - add proper license below
LICENSE = "CLOSED"

SRC_URI = " file://mxcfb.h \
			file://epdc_ES103TC1C1.fw"

PV = "1.0"

S = "${WORKDIR}"

inherit allarch

do_install() {
	install -d ${D}/home/root/Collections
	install -d ${D}/home/root/library
	install -d ${D}/home/root/Downloads
	install -d ${D}/home/root/Collaborations
	install -d ${D}/home/root/screenshots
	install -d ${D}/home/root/library/readable
	install -d ${D}/home/root/library/audible
	install -d ${D}/home/root/library/bookmarks

	install -d ${D}${includedir}/linux
	install -m 0755 ${WORKDIR}/mxcfb.h ${D}${includedir}/linux/

	install -d ${D}${base_libdir}/firmware/imx/epdc
	install -m 0755 ${WORKDIR}/epdc_ES103TC1C1.fw ${D}${base_libdir}/firmware/imx/epdc/
}

FILES_${PN} += "/home/root/*"
FILES_${PN} += "${includedir}/linux/mxcfb.h"
FILES_${PN} += "${base_libdir}/firmware/imx/epdc/epdc_ES103TC1C1.fw"
