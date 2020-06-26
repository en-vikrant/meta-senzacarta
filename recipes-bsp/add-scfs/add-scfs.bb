# Copyright (C) 2020 SenzaCarta

SUMMARY = "SenzaCarta Project Directory Structure"
# FIXME - add proper license below
LICENSE = "CLOSED"

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
}

FILES_${PN} += "/home/root/*"
