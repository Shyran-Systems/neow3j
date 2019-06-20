#!/usr/bin/env bash

SNAPSHOT_TAG_PATTERN="(\d+(\.\d+){1,2}(\.\*)?)-SNAPSHOT$"

if [ "$TRAVIS_TAG" =~ $SNAPSHOT_TAG_PATTERN  ]; then
    PARAMS="-Psnapshot"
fi

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
  openssl aes-256-cbc -K $encrypted_f2caa0a2639d_key -iv $encrypted_f2caa0a2639d_iv -in ./scripts/neow3j.gpg.enc -out ./scripts/neow3j.gpg -d
  ./gradlew releaseAndClose -PnexusUsername=${SONATYPE_USERNAME} -PnexusPassword=${SONATYPE_PASSWORD} -Psigning.keyId=${GPG_KEY_ID} -Psigning.password=${GPG_KEY_PASSPHRASE} -Psigning.secretKeyRingFile=./scripts/neow3j.gpg ${PARAMS}
fi