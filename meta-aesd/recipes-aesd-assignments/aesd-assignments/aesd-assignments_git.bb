LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignments-3-and-later-bwitherspoon.git;protocol=ssh;branch=main"

#SRCREV = "${AUTOREV}"
SRCREV ="a6afe51e4cb399d60b4d7f80d8405b03c9b2b04f"
PV = "0.1.0+git${SRCPV}"

S = "${WORKDIR}/git/server"

inherit update-rc.d

FILES:${PN} += "${bindir}/aesdsocket"
TARGET_LDFLAGS += "-pthread -lrt"

INITSCRIPT_NAME = "aesdsocket"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -Dm 0755 ${S}/aesdsocket ${D}${bindir}/aesdsocket
	install -Dm 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/aesdsocket
}
